package com.bruno.clutchskins.mappers;

import com.bruno.clutchskins.entities.Skin;
import com.bruno.clutchskins.entities.Weapon;
import com.bruno.clutchskins.requests.SkinResponse;
import com.bruno.clutchskins.requests.SkinPostRequestBody;
import com.bruno.clutchskins.requests.SkinPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SkinMapper {

    SkinMapper INSTANCE = Mappers.getMapper(SkinMapper.class);

    Skin toSkin(SkinPostRequestBody skinPostRequestBody);

    Skin toSkin(SkinPutRequestBody skinPutRequestBody);

    @Mapping(target = "weapon", expression = "java(receiveWeaponName(skin.getWeaponName()))")
    SkinResponse mapSkinDto(Skin skin);

    List<SkinResponse> mapList(List<Skin> skins);

    default String receiveWeaponName(Weapon weapon) {
        return weapon.getName();
    }


}
