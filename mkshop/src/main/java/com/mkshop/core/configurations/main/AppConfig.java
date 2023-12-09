package com.mkshop.core.configurations.main;

import com.mkshop.mkshop.data.application.gateways.*;
import com.mkshop.mkshop.data.application.useCases.address.*;
import com.mkshop.mkshop.data.application.useCases.category.*;
import com.mkshop.mkshop.data.application.useCases.order.CreateOrderInteractor;
import com.mkshop.mkshop.data.application.useCases.order.DeleteOrderInteractor;
import com.mkshop.mkshop.data.application.useCases.order.GetAllOrderInteractor;
import com.mkshop.mkshop.data.application.useCases.order.GetOrderInteractor;
import com.mkshop.mkshop.data.application.useCases.product.*;
import com.mkshop.mkshop.data.application.useCases.product_order.GetAllProductOrderInteractor;
import com.mkshop.mkshop.data.application.useCases.user.*;
import com.mkshop.mkshop.data.infrastructure.gateways.*;
import com.mkshop.mkshop.data.infrastructure.persistence.*;
import com.mkshop.mkshop.data.mappers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    CreateUserInteractor createUserUseCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    EditUserInteractor editUserUseCase(UserGateway userGateway) {
        return new EditUserInteractor(userGateway);
    }

    @Bean
    DeleteUserInteractor deleteUserUseCase(UserGateway userGateway) {
        return new DeleteUserInteractor(userGateway);
    }

    @Bean
    GetAllUsersInteractor getAllUsersUseCase(UserGateway userGateway) {
        return new GetAllUsersInteractor(userGateway);
    }

    @Bean
    GetUserByIdInteractor getUserByIdUseCase(UserGateway userGateway) {
        return new GetUserByIdInteractor(userGateway);
    }

    @Bean
    GetUserByUsernameInteractor getUserByUsernameUseCase(UserGateway userGateway) {
        return new GetUserByUsernameInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserMapper userMapper) {
        return new UserGatewayRepository(userRepository, userMapper);
    }
    /////////////////////////////////////////////////////////////////
    @Bean
    DeleteAddressByIdInteractor deleteAddressByIdInteractor(AddressGateway addressGateway) {
        return new DeleteAddressByIdInteractor(addressGateway);
    }
    @Bean
    EditAddressInteractor editAddressInteractor(AddressGateway addressGateway) {
        return new EditAddressInteractor(addressGateway);
    }
    @Bean
    GetAddressByIdInteractor getAddressByIdInteractor(AddressGateway addressGateway) {
        return new GetAddressByIdInteractor(addressGateway);
    }
    @Bean
    GetAllAddressInteractor getAllAddressInteractor(AddressGateway addressGateway){
        return new GetAllAddressInteractor(addressGateway);
    }
    @Bean
    CreateAddressInteractor createAddressInteractor(AddressGateway addressGateway) {
        return new CreateAddressInteractor(addressGateway);
    }

    @Bean
    AddressGateway addressGateway(AddressRepository addressRepository, AddressMapper addressMapper) {
        return new AddressGatewayRepository(addressRepository, addressMapper);
    }
    //////////////

    @Bean
    CreateCategoryInteractor createCategoryInteractor(CategoryGateway categoryGateway) {
        return new CreateCategoryInteractor(categoryGateway);
    }

    @Bean
    DeleteCategoryByIdInteractor deleteCategoryByIdInteractor(CategoryGateway categoryGateway) {
        return new DeleteCategoryByIdInteractor(categoryGateway);
    }
    @Bean
    EditCategoryInteractor editCategoryInteractor(CategoryGateway categoryGateway) {
        return new EditCategoryInteractor(categoryGateway);
    }
    @Bean
    GetAllCategoriesInteractor getAllCategoriesInteractor(CategoryGateway categoryGateway) {
        return new GetAllCategoriesInteractor(categoryGateway);
    }
    @Bean
    GetCategoryByIdInteractor getCategoryByIdInteractor(CategoryGateway categoryGateway) {
        return new GetCategoryByIdInteractor(categoryGateway);
    }
    @Bean
    CategoryGateway categoryGateway(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        return new CategoryGatewayRepository(categoryRepository, categoryMapper);
    }
    ////////////////
    @Bean
    CreateOrderInteractor createOrderInteractor(OrderGateway orderGateway) {
        return new CreateOrderInteractor(orderGateway);
    }
    @Bean
    DeleteOrderInteractor deleteOrderInteractor(OrderGateway orderGateway) {
        return new DeleteOrderInteractor(orderGateway);
    }
    @Bean
    GetAllOrderInteractor getAllOrderInteractor(OrderGateway orderGateway) {
        return new GetAllOrderInteractor(orderGateway);
    }
    @Bean
    GetOrderInteractor getOrderInteractor(OrderGateway orderGateway) {
        return new GetOrderInteractor(orderGateway);
    }
    @Bean
    OrderGateway orderGateway(
            OrderRepository orderRepository,
            OrderMapper orderMapper,
            ProductMapper productMapper,
            ProductOrderRepository productOrderRepository
    ) {
        return new OrderGatewayRepository(
                orderRepository,
                orderMapper,
                productMapper,
                productOrderRepository
        );
    }
    //////////
    @Bean
    CreateProductInteractor createProductInteractor(ProductGateway productGateway) {
        return new CreateProductInteractor(productGateway);
    }
    @Bean
    EditProductInteractor editProductInteractor(ProductGateway productGateway) {
        return new EditProductInteractor(productGateway);
    }
    @Bean
    DeleteProductInteractor deleteProductInteractor(ProductGateway productGateway) {
        return new DeleteProductInteractor(productGateway);
    }
    @Bean
    GetAllMainProductsInteractor getAllMainProductsInteractor(ProductGateway productGateway) {
        return new GetAllMainProductsInteractor(productGateway);
    }
    @Bean
    GetAllProductsInteractor getAllProductsInteractor(ProductGateway productGateway) {
        return new GetAllProductsInteractor(productGateway);
    }
    @Bean
    GetProductByIdInteractor getProductByIdInteractor(ProductGateway productGateway) {
        return new GetProductByIdInteractor(productGateway);
    }
    @Bean
    GetProductsByNameInteractor getProductsByNameInteractor(ProductGateway productGateway) {
        return new GetProductsByNameInteractor(productGateway);
    }
    @Bean
    ProductGateway productGateway(
            ProductRepository productRepository,
            ProductMapper productMapper,
            CategoryRepository categoryRepository,
            ImageProductRepository imageProductRepository
    ) {
        return new ProductGatewayRepository(
                productRepository,
                productMapper,
                categoryRepository,
                imageProductRepository
        );
    }
    ////
    @Bean
    GetAllProductOrderInteractor getAllProductOrderInteractor(ProductOrderGateway productOrderGateway) {
        return new GetAllProductOrderInteractor(productOrderGateway);
    }
    @Bean
    ProductOrderGateway productOrderGateway(
            ProductOrderRepository productOrderRepository,
            ProductOrderMapper productOrderMapper
    ) {
        return new ProductOrderGatewayRepository(
                productOrderRepository,
                productOrderMapper
        );
    }
}
