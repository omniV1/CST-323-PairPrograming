package com.gcu.models;

public class Mapper {

    // Convert OrderModel to OrderEntity
    public static OrderEntity toEntity(OrderModel model) {
        OrderEntity entity = new OrderEntity();
        entity.setId(model.getId());
        entity.setOrder_number(model.getOrder_number());
        entity.setProduct_name(model.getProduct_name());
        entity.setPrice(model.getPrice());
        entity.setQuantity(model.getQuantity());
        return entity;
    }

    // Convert OrderEntity to OrderModel
    public static OrderModel toModel(OrderEntity entity) {
        OrderModel model = new OrderModel();
        model.setId(entity.getId());
        model.setOrder_number(entity.getOrder_number());
        model.setProduct_name(entity.getProduct_name());
        model.setPrice(entity.getPrice());
        model.setQuantity(entity.getQuantity());
        return model;
    }
}
