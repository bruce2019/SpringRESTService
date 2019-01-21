# SpringRESTService

Microservice to update counter concurrently.

#### Code Checkout
* Checkout the code locally using
> cd yourWorkingDirectory

> git clone https://github.com/RishiRajSahu/SpringRESTService.git

#### Database
* Start local mysql using docker, assuming docker is already installed on your machine
> cd yourWorkingDirectory/SpringRESTService
```
> docker-compose up
```
The above command will start a local mysql image on docker whose ports are exposed at 3306 for more info check yml file

* If you have mysql installed already you can directly use the config of that inside `applicaiton.properties` file

### Run the service locally
* Assuming your eclipse have maven plugin installed, import the checkout project as an existing maven project to your workspace
* Change the mysql configuration if your not using docker image under the file `applicaiton.properties`
* Open the file `SpringRestServiceApplication` in your eclipse and run it, this will create table `counter` in the database.
* On terminal login to mysql shell `mysql -h 127.0.0.1 -P 3306 -u user -p`
* Run ` show databases` to see the databases.
* Run ` select db` to select database db.
* Run ` insert into counter(count) values(0);` make sure you run this command only once in the lifecycle of app.
* Open the Jmeter client using startup script
* import the .jmx file to jmeter and run the tests
