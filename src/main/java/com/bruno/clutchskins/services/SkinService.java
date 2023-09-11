package com.bruno.clutchskins.services;

import com.bruno.clutchskins.entities.Skin;
import com.bruno.clutchskins.mappers.SkinMapper;
import com.bruno.clutchskins.repositories.SkinRepository;
import com.bruno.clutchskins.requests.SkinResponse;
import com.bruno.clutchskins.requests.SkinPostRequestBody;
import com.bruno.clutchskins.requests.SkinPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkinService {

    private final SkinRepository skinRepository;


    public List<SkinResponse> listAll() {
        return SkinMapper.INSTANCE.mapList(skinRepository.findAll());
    }

    public SkinResponse findById(Long id) {
        return SkinMapper.INSTANCE.mapSkinDto(skinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid id")));
    }

    public Skin save(SkinPostRequestBody skinPostRequestBody) {
        return skinRepository.save(SkinMapper.INSTANCE.toSkin(skinPostRequestBody));
    }

    public Skin replace(SkinPutRequestBody skinPutRequestBody) {
        return skinRepository.save(SkinMapper.INSTANCE.toSkin(skinPutRequestBody));
    }

    public void delete(Long id) {
        skinRepository.deleteById(id);
    }

}
