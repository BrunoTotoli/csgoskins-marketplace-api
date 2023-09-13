package com.bruno.clutchskins.services;

import com.bruno.clutchskins.entities.Skin;
import com.bruno.clutchskins.mappers.SkinMapper;
import com.bruno.clutchskins.repositories.SkinRepository;
import com.bruno.clutchskins.repositories.WeaponRepository;
import com.bruno.clutchskins.requests.SkinPostRequestBody;
import com.bruno.clutchskins.requests.SkinPutRequestBody;
import com.bruno.clutchskins.requests.SkinResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bruno.clutchskins.utils.PageUtils.createPageFromList;
import static com.bruno.clutchskins.utils.PageUtils.createPageRequestUsing;

@Service
@RequiredArgsConstructor
@Log4j2
public class SkinService {

    private final SkinRepository skinRepository;
    private final WeaponRepository weaponRepository;


    public Page<SkinResponse> listAll(int page, int size) {
        Pageable pageRequestUsing = createPageRequestUsing(page, size);
        return createPageFromList(SkinMapper.INSTANCE.mapList(skinRepository.findAll()), pageRequestUsing);
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

    public List<Skin> findSkinListByWeaponName(String weaponName) {
        return weaponRepository.findWeaponByName(weaponName).getSkins();
    }

}
