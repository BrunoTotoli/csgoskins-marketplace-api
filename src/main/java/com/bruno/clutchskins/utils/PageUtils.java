package com.bruno.clutchskins.utils;

import com.bruno.clutchskins.requests.SkinResponse;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@UtilityClass
public class PageUtils {

    public static Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }


    public static Page<SkinResponse> createPageFromList(List<SkinResponse> skinResponses, Pageable pageRequest) {
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), skinResponses.size());

        List<SkinResponse> pageContent = skinResponses.subList(start, end);
        return new PageImpl<>(pageContent, pageRequest, skinResponses.size());
    }

}
