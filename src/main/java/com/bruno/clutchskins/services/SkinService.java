package com.bruno.clutchskins.services;

import com.bruno.clutchskins.entities.Skin;
import com.bruno.clutchskins.entities.enums.Exterior;
import com.bruno.clutchskins.exceptions.EntityNotFoundException;
import com.bruno.clutchskins.exceptions.InvalidFloatException;
import com.bruno.clutchskins.repositories.CategoryRepository;
import com.bruno.clutchskins.repositories.SkinRepository;
import com.bruno.clutchskins.repositories.WeaponRepository;
import com.bruno.clutchskins.requests.SkinPostRequestBody;
import com.bruno.clutchskins.requests.SkinPutRequestBody;
import com.bruno.clutchskins.requests.SkinResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bruno.clutchskins.mappers.SkinMapper.SKINMAPPER;
import static com.bruno.clutchskins.utils.PageUtils.createPageFromList;
import static com.bruno.clutchskins.utils.PageUtils.createPageRequestUsing;

@Service
@RequiredArgsConstructor
@Log4j2
public class SkinService {

    private final SkinRepository skinRepository;
    private final WeaponRepository weaponRepository;
    private final CategoryRepository categoryRepository;


    public Page<SkinResponse> findAllSkinsPageable(int page, int size) {
        Pageable pageRequestUsing = createPageRequestUsing(page, size);
        return createPageFromList(SKINMAPPER.mapList(skinRepository.findAll()), pageRequestUsing);
    }

    public SkinResponse findById(Long id) {
        return SKINMAPPER.mapSkinDto(skinRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invalid id :" + id)));
    }

    public Skin save(SkinPostRequestBody skinPostRequestBody) {
        if (skinPostRequestBody.getSkinFloat() < skinPostRequestBody.getExterior().getMinFloat()
                || skinPostRequestBody.getSkinFloat() > skinPostRequestBody.getExterior().getMaxFloat()) {
            Exterior exterior = skinPostRequestBody.getExterior();
            throw new InvalidFloatException("The float is not valid with exterior. " + exterior +
                    " minFloat: " + exterior.getMinFloat() + " maxFloat: " + exterior.getMaxFloat()+
                    " currentFloat: " +skinPostRequestBody.getSkinFloat());
        }
        return skinRepository.save(SKINMAPPER.toSkin(skinPostRequestBody));
    }

    public Skin replace(SkinPutRequestBody skinPutRequestBody) {
        if (skinPutRequestBody.getSkinFloat() < skinPutRequestBody.getExterior().getMinFloat()
                || skinPutRequestBody.getSkinFloat() > skinPutRequestBody.getExterior().getMaxFloat())
            throw new InvalidFloatException("The float is not valid with exterior");
        return skinRepository.save(SKINMAPPER.toSkin(skinPutRequestBody));
    }

    public void delete(Long id) {
        skinRepository.deleteById(id);
    }

    public List<SkinResponse> findSkinListByWeaponName(String weaponName) {
        return SKINMAPPER.mapList(weaponRepository.findWeaponByName(weaponName).getSkins());
    }

    public List<SkinResponse> findSkinListByCategory(String category) {
        return SKINMAPPER.mapList(categoryRepository.findCategoryByName(category).getSkinList());
    }
}
