# Supplementary Specification (FURPS+)

## Functionality
_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._

****************************************

***************************************


## Usability
_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

****************************************
The only language available it's going to be english.
The application must be easy to manage for users, technicians and doctors to insert and read information.
With the app comes together a user manual to help the users.
***************************************


## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

****************************************

***************************************


## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

****************************************
The app should be able to withstand several active users.
The app should be efficient to decrease the number of tests waiting for its result.
It should be able to keep a register of the number of tests performed, and the ones that are positives.
***************************************


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

****************************************
Many Labs will be responsible for the app's maintenance.
The app covers all England and every Many Labs's employee interacts with the clients.
The app must be able to register several clients info and the tests they are going to do.
The app should be compatible with SMS and email.
***************************************


## +

### Design Constraints
_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

****************************************
The app is developed in Java language and the graphical interface in JavaFX 11.
The software implementation process is OO.
The unit tests should be implemented using the JUnit 4 framework.
The JaCoCo plugin should be used to generate the coverage report.
All the images/figures produced during the software development process should be recorded in SVG format.

***************************************


### Implementation Constraints
_Specifies or constraints the code or construction of a system such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

****************************************
The keywords used in the app must have, seven alphanumeric characters, including three capital letters and two digits.
Only the specialist doctor is allowed to access all client data.
It's going to be use Javadoc to generate usefaul documentation for Java code.

***************************************


### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

****************************************

***************************************


### Physical Constraints
_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

****************************************

***************************************