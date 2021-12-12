![](https://github.com/qwe3804132/Palitronica-TaxCalculator/blob/main/md/tag.png?raw=true)
# Palitronica coding challenge - TaxCalculator
### 1. Setup and running the application
For start the application, please use your terminal go the the source folder of git and run the command
```
docker-compose up

```
It will trigger the Dockerfile which located in the both front-end and back-end project, start the building process and pulling the latest version of mysql database. In the same time a datadump.sql script will be execute and import the data into database automatically.
![](https://github.com/qwe3804132/Palitronica-TaxCalculator/blob/main/md/build.png?raw=true)
Once you see the three "done" words show up on the bottom of your terminal which means the building and deploying process has been finished successfully.
![](https://github.com/qwe3804132/Palitronica-TaxCalculator/blob/main/md/spring%20DAO.png?raw=true)
The above pricture shows that both services has been successfully started and both SpringBoot application and DAO layer ORM has been triggered.
> For now, the  Palitronica Warehouse Address set as: 151 Charles St W Suite #199 Kitchener, ON, N2G 1H6. Currently two customers who living in the different state(ON and Qubec City) sharing the different tax rate has been added into datadump.sql, if you need more customers for testing on the calculation result, please kindly adding them into the datadump.sql file and be aware of the data format requirement of TaxJar API https://developers.taxjar.com/api/reference/?java#introduction
 
</br>
### 2. Access the front-end
After finish the step 1, you are supposed to access the front-end application by accessing the browser on
```
http://localhost:9090/
```

