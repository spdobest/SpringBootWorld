# Spring Boot -JPA
(@OneToMany and @ManyToOne)  
- In JPA, one-to-many database association can be represented either
through a @ManyToOne or @OneToMany association or both. All
depends on our requirement and need.
- @ManyToOne annotation allows us to map the Foreign Key column
in the child entity mapping so that child has an entity object
reference to its parent entity. This is the most effecient way.
- We can perform the associations in below listed 3 ways
    - Unidirectional @OneToMany association
    - Bidirectional @OneToMany association
    - Unidirectional @ManyToOne with JPQL query
 
## Use Case Introduction
- Get all orders of a user
    - Method name: getAllOrders
    - GET /users/{userid}/orders
- Create an order for a user
    - Method name: createOrder
    - GET /users/{userid}/orders
- Get order details using orderid and userid
    - Method name: createOrder
    - GET /users/{userid}/orders/{orderid}
           
## JPA - @OneToMany - Implementation Steps
- Step 01: Create branch for JPA one-to-many    
- Step 02: Create Order entity and @ManyToOne association
- Step 03: Update User Entity with @OneToMany Association
- Step 04: Implement getAllOrders method
- Step 05: Implement createOrder Method
- Step 06: Implement getOrderByOrderId method (Assignment)
- Step 07 - commit and push
    
## STEP 02 - Create Order entity and @ManyToOne association
- Entity Layer  
    - Create Order Entity
    - Annotate with @Table(name = "orders")
    - Add User variable
    - Add @ManyToOne Mapping
    - Add Fetch TYpe as lazy
    - Add @JsonIgnore
    - Add Getters and Setters
    - Add NoArgument Constructor
      
## STEP 03 - Update User Entity with @OneToMany Association
- Add Orders variable
- Add @OneToMany Mapping
- Add MappedBy to user variable in order Entity
- Add getters and setters for "orders"
- src/main/resources
    - update data.sql    
        
**Option#1: Verify Column and create insert query**  
insert into orders values(2001,''order11',101);  
insert into orders values(2002,''order12',101);  
insert into orders values(2003,''order13',101);  
insert into orders values(2004,''order21',102);  
insert into orders values(2005,''order22',102);  
insert into orders values(2006,''order31',103);   
    
**Option#2: Verify Foreign key name in DB before creating below insert queries**  
  
insert into orders values(orderid,orderDescription,user_user_id) values(2001,'order11',101);      
insert into orders values(orderid,orderDescription,user_user_id) values(2002,'order12',101);      
insert into orders values(orderid,orderDescription,user_user_id) values(2003,'order13',101);      
insert into orders values(orderid,orderDescription,user_user_id) values(2004,'order21',102);      
insert into orders values(orderid,orderDescription,user_user_id) values(2005,'order22',102);      
insert into orders values(orderid,orderDescription,user_user_id) values(2006,'order31',103);      
   
## STEP 04 - Implements "getAllOrders" method in OrderController
- Controller Layer: UserController
    - Add @RequestMapping at class level and add "/users" context at class level
    - Remove "/users" at method level for all users related methods
- Controller Layer: OrderController
    - Annotate with @RestController
    - Annotate with @RequestMapping
    - Method: getAllOrders
    - GET /users/{userid}/orders
- Test Using Postman
    - Test#1: getAllOrders
        - GET /users/101/orders
    - Test#2: getAllUsers
        - GET /users
    - Test#3: getUserById
        - GET /users/101
  
## STEP 05 - Implements "createOrder" method in OrderController   
- Repository Layer
    - Create OrderRepository
- Controller Layer: OrderController
    - Method: createOrder
    - POST: /users/{userid}/orders
- Test Using POSTMAN
    - Test#1: createOrder
        - POST users/101/order
    - Test#2: getALlOrder
        - GET users/101/orders            
    - Test#3: getAllUsers
        - GET /users 
    - Test#1: createOrder
        - GET /users/101 

  
## STEP 06 - Implements "getOrderByOrderId" method in OrderController   
- Controller Layer: OrderController
    - Method: getOrderByOrderId
    - GET: /users/{userid}/orders/{orderId}
- Test Using POSTMAN
    - Test#1: getOrderByOrderId
        - GET users/{userId}}/orders/{orderId}

        