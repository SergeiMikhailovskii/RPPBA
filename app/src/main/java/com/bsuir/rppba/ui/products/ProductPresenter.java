package com.bsuir.rppba.ui.products;

import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.BasePresenter;
import com.bsuir.rppba.ui.products.ProductContract;

import java.util.ArrayList;
import java.util.List;

public class ProductPresenter extends BasePresenter<ProductContract.ProductView> implements ProductContract.ProductsPresenter {

    @Override
    public void loadProductsList() {
        view.showLoadingIndicator(true);

        List<StockItem> productsList = new ArrayList<>();

        productsList.add(new StockItem("https://s3-alpha-sig.figma.com/img/de92/669d/1f1dd0b493cda7ba55446e552d34c5e8?Expires=1585526400&Signature=bgKxyNXUD4N5Dr6BnsnUHzkHljxodP9bxjTGvBaxyYAkcAtLrSie9ux9yBk~qm2c5yxPBvGVex68yuzfyMwcg8Y9Ck1x-ZLnu5pG~izkE3VQcDjopssTiY6NNsQFVGhBimDGXxWTtx1vYYpcBreBBNgpvMP6NUXHNn9YCYMgRg5-WDEs9cBOlMvR-aKeI448G322XEPKcnzpj8xTorrAYatG5u~txzjMwsd4LRPH3~55owm2rOuVWEO1SeFTB7z5~rK7N187AC6K61OinXWCQiImbHGqIGkHRk70xaLb3J5bu6czm9iwPPCTSc65QrZti0qRtWm8nygr-FMFeW4sIw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                "Pen",
                "Standart_L",
                100,
                new ArrayList<>()));

        productsList.add(new StockItem("https://s3-alpha-sig.figma.com/img/de92/669d/1f1dd0b493cda7ba55446e552d34c5e8?Expires=1585526400&Signature=bgKxyNXUD4N5Dr6BnsnUHzkHljxodP9bxjTGvBaxyYAkcAtLrSie9ux9yBk~qm2c5yxPBvGVex68yuzfyMwcg8Y9Ck1x-ZLnu5pG~izkE3VQcDjopssTiY6NNsQFVGhBimDGXxWTtx1vYYpcBreBBNgpvMP6NUXHNn9YCYMgRg5-WDEs9cBOlMvR-aKeI448G322XEPKcnzpj8xTorrAYatG5u~txzjMwsd4LRPH3~55owm2rOuVWEO1SeFTB7z5~rK7N187AC6K61OinXWCQiImbHGqIGkHRk70xaLb3J5bu6czm9iwPPCTSc65QrZti0qRtWm8nygr-FMFeW4sIw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                "Pen",
                "Standart_M",
                100,
                new ArrayList<>()));

        productsList.add(new StockItem("https://s3-alpha-sig.figma.com/img/de92/669d/1f1dd0b493cda7ba55446e552d34c5e8?Expires=1585526400&Signature=bgKxyNXUD4N5Dr6BnsnUHzkHljxodP9bxjTGvBaxyYAkcAtLrSie9ux9yBk~qm2c5yxPBvGVex68yuzfyMwcg8Y9Ck1x-ZLnu5pG~izkE3VQcDjopssTiY6NNsQFVGhBimDGXxWTtx1vYYpcBreBBNgpvMP6NUXHNn9YCYMgRg5-WDEs9cBOlMvR-aKeI448G322XEPKcnzpj8xTorrAYatG5u~txzjMwsd4LRPH3~55owm2rOuVWEO1SeFTB7z5~rK7N187AC6K61OinXWCQiImbHGqIGkHRk70xaLb3J5bu6czm9iwPPCTSc65QrZti0qRtWm8nygr-FMFeW4sIw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                "Pen",
                "High_L",
                100,
                new ArrayList<>()));

        productsList.add(new StockItem("https://s3-alpha-sig.figma.com/img/de92/669d/1f1dd0b493cda7ba55446e552d34c5e8?Expires=1585526400&Signature=bgKxyNXUD4N5Dr6BnsnUHzkHljxodP9bxjTGvBaxyYAkcAtLrSie9ux9yBk~qm2c5yxPBvGVex68yuzfyMwcg8Y9Ck1x-ZLnu5pG~izkE3VQcDjopssTiY6NNsQFVGhBimDGXxWTtx1vYYpcBreBBNgpvMP6NUXHNn9YCYMgRg5-WDEs9cBOlMvR-aKeI448G322XEPKcnzpj8xTorrAYatG5u~txzjMwsd4LRPH3~55owm2rOuVWEO1SeFTB7z5~rK7N187AC6K61OinXWCQiImbHGqIGkHRk70xaLb3J5bu6czm9iwPPCTSc65QrZti0qRtWm8nygr-FMFeW4sIw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                "Pen",
                "High_M",
                100,
                new ArrayList<>()));

        productsList.add(new StockItem("https://s3-alpha-sig.figma.com/img/de92/669d/1f1dd0b493cda7ba55446e552d34c5e8?Expires=1585526400&Signature=bgKxyNXUD4N5Dr6BnsnUHzkHljxodP9bxjTGvBaxyYAkcAtLrSie9ux9yBk~qm2c5yxPBvGVex68yuzfyMwcg8Y9Ck1x-ZLnu5pG~izkE3VQcDjopssTiY6NNsQFVGhBimDGXxWTtx1vYYpcBreBBNgpvMP6NUXHNn9YCYMgRg5-WDEs9cBOlMvR-aKeI448G322XEPKcnzpj8xTorrAYatG5u~txzjMwsd4LRPH3~55owm2rOuVWEO1SeFTB7z5~rK7N187AC6K61OinXWCQiImbHGqIGkHRk70xaLb3J5bu6czm9iwPPCTSc65QrZti0qRtWm8nygr-FMFeW4sIw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                "Pen",
                "Low_L",
                100,
                new ArrayList<>()));

        productsList.add(new StockItem("https://s3-alpha-sig.figma.com/img/57a9/8dc6/804577e34c584f12c771dc29783bda20?Expires=1585526400&Signature=bURuq0V6YTbZN4SKNXLN-YDOUqQRkQLg06~fPPzd-vRuDV23pPyX8P5T5dXA133-acI3Mrjx8GVYGRwOgohl5u~6b-d9XH3LjnmcW3BUmEibJvZoOzykYn4KUEKDx~CwWn-LLC1kJcJV0G04AI5QJ7oLvIZKqUtAFYEChtw8bwdWtA-3wh-v9YQNPVO5P1p2Hubql43IqYBjNTvEouaFVlBis7kV8Q3tFLKf5sfFqF18wnsJmi1KA9-dMt-nhUkcrtMNbCjG-mwTEh-v4q3gY~UNitVrmI6tg7uFiM2fXPLa5Gm659wq75EbpfVXsyzSReo2UNe8sExyywJX6sNj7w__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
                "Pencil",
                "Big_White",
                100,
                new ArrayList<>()));

        view.showLoadingIndicator(false);
        view.onProductsLoaded(productsList);

    }

}
