package tdd.vendingMachine.model.builder;

import java.util.concurrent.atomic.AtomicInteger;

import tdd.vendingMachine.model.Product;
import tdd.vendingMachine.model.Shelf;

public class ShelfBuilder implements IBuilder<Shelf> {
    private Product product;
    private AtomicInteger productCount;

    public ShelfBuilder withProduct(IBuilder<Product> product) {
        this.product = product.build();
        return this;
    }

    public ShelfBuilder withProductCount(int productCount) {
        this.productCount = new AtomicInteger(productCount);
        return this;
    }

    @Override
    public Shelf build() {
        Shelf shelf = new Shelf();
        shelf.setProduct(this.product);
        shelf.setProductCount(this.productCount);
        return shelf;
    }
}
