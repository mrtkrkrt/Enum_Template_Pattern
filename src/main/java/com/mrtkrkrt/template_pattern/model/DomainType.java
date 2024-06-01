package com.mrtkrkrt.template_pattern.model;

import com.mrtkrkrt.template_pattern.holder.AppContextHolder;
import com.mrtkrkrt.template_pattern.service.ChineseRestaurant;
import com.mrtkrkrt.template_pattern.service.TurkishRestaurant;
import com.mrtkrkrt.template_pattern.service.common.RestaurantService;

public enum DomainType {
    CHINESE_RESTAURANT(

    ) {
        @Override
        public RestaurantService execute() {
            return AppContextHolder.getBean(ChineseRestaurant.class);
        }
    },
    TURKISH_RESTAURANT(

    ) {
        @Override
        public RestaurantService execute() {
            return AppContextHolder.getBean(TurkishRestaurant.class);
        }
    };

    public abstract RestaurantService execute();
}
