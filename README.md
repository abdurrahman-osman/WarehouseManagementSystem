# Projeyi yapanlar
* Abdurrahman Osman    linkedIn: https://www.linkedin.com/in/abmu2/
* Mehmet Baykal        linkedIn: https://www.linkedin.com/in/mehmetbaykal61/


# Warehouse Management System Rest API

* PORT:8080 

# Gereksinimler

* Spring Boot
* Spring Web
* Jpa
* Hibernate
* Postgres & H2
* Lombok

# Uygulama Özellikleri

Depo yönetim sistemi ile, bir şirketin ürünlerini sakladığı, listelediği, depolar arasında transfer yapabildiği, depolar ve ürünler üzerinde CRUD işlemlerini yapabildiği bir sistem yazıyor olacağız.


# Modeller

1. Warehouse
2. Product
3. ProductWarehouse

**Warehouse**

Depomuzun özellikleri aşağıdaki gibidir.
* Depo ID'si (ID) (Primary Key)
* Depo Kodu (Code)
* Depo'nun ismi (Name)
* Deponun statüsü ( WarehouseStatus {ACTIVE, PASSIVE, DELETED} )
* Kayıt Tarihi (CreateDate)
* Güncelleme Tarihi (UpdateDate)

**Product**
Ürüne ait özellikle aşağıodaki gibidir.

* Ürün ID'si (ID) ( Primary Key )
* Ürün Kodu (Code)
* Ürünün ismi (Name)
* Ürünün KDV'si (VATRate)
* Ürünün KDV Fiyatı (VatAmount)
* Ürünün KDV'siz Fiyatı (BasePrice)
* Ürünün KDV Dahil fiyatı (VatIncludedPrice)
* Ürünün durumu ( ProductStatus {ACTIVE, PASSIVE} )
* Kayıt Tarihi (CreateDate)
* Güncelleme Tarihi (UpdateDate)


**ProductWarehouse**
Bu model İlişkisel olarak depo - ürün bilgisini tutacaktır. Özellikleri aşağıdaki gibidir.

* Ürün ID'si (ProductId)
* Depo ID'si (WarehouseId)
* Stok Miktarı (StockAmount)
* İşlem zamanı (TransactionDate)


# Fonksiyonlar

**WarehouseController**


1. Depo Listeleme
   * **Method Name** = list
   * **HTTP Request Type** = GET
   * **End Point** = /warehouseapi/warehouses

2. ID ile Listeleme
   * **Method Name** = list
   * **HTTP Request Type** = GET
   * **End Point** = /warehouseapi/warehouses

3. Depo Oluşturma
   * **Method Name** = create
   * **HTTP Request Type** = POST
   * **End Point** = /warehouseapi/warehouses

4. Depo Güncelleme
   * **Method Name** = update
   * **HTTP Request Type** = PUT
   * **End Point** = /warehouseapi/warehouses/{warehouseId}

5. Depo Silme
   * **Method Name** = delete
   * **HTTP Request Type** = DELETE
   * **End Point** = /warehouseapi/warehouses/{warehouseId}

6. Depo Transfer
   * **Method Name** = transfer
   * **HTTP Request Type** = POST
   * **EndPoint** = /warehouseapi/warehouses/transfer



**ProductController**

1. Ürün Listeleme
   * **Method Name** = list
   * **HTTP Request Type** = GET
   * **End Point** = /warehouseapi/products

2. ID ile Listeleme
   * **Method Name** = list
   * **HTTP Request Type** = GET
   * **End Point** = /warehouseapi/products/{productId}

3. Ürün Oluşturma
   * **Method Name** = create
   * **HTTP Request Type** = POST
   * **End Point** = /warehouseapi/products

4. Ürün Güncelleme
   * **Method Name** = update
   * **HTTP Request Type** = PUT
   * **End Point** = /warehouseapi/products/{productId}

5. Ürün Silme
   * **Method Name** = delete
   * **HTTP Request Type** = DELETE
   * **End Point** = /warehouseapi/products/{productId}

**ProductWarehouseController**

1. Transfer
   * **Method Name** = transfer
   * **HTTP Request Type** = PUT
   * **EndPoint** = /warehouseapi/productwarehouse/transfer/product

2. Depoya Ürün Ekleme
   * **Method Name** = add
   * **HTTP Request Type** = POST
   * **End Point** = /warehouseapi/productwarehouse

2. Güncelleme
   * **Method Name** = update
   * **HTTP Request Type** = PUT
   * **End Point** = /warehouseapi/productwarehouse/update

3. Özet Bilgi
   * **Method Name** = summaries
   * **HTTP Request Type** = GET
   * **End Point** = warehouseapi/productwarehouse/transfer
   
    
    
    
 

    


