# Use Case Diagram (UCD)

**In the scope of this project, there is a direct relationship of _1 to 1_ between Use Cases (UC) and User Stories (US).**

However, be aware, this is a pedagogical simplification. On further projects and curricular units might also exist _1 to N **and/or** N to 1 relationships between US and UC.

**Insert below the Use Case Diagram in a SVG format**

![Use Case Diagram](UCD.svg)


**For each UC/US, it must be provided evidences of applying main activities of the software development process (requirements, analysis, design, tests and code). Gather those evidences on a separate file for each UC/US and set up a link as suggested below.**

# Use Cases / User Stories
| UC/US  | Description                                                               |                   
|:----|:------------------------------------------------------------------------|
| US1 | The user has to register in the application with is email and password. |
| US2 | To register a client, the receptionist needs the client’s citizen card number, National Healthcare Service (NHS) number, birth date, sex, Tax Identification number (TIF), phone number, e-mail and name. |
| US3 | Once there, a receptionist asks the client’s citizen card number, the lab order (which contains the type of test and parameters to be measured), and registers in the application the test to be performed to that client.|
| US4 | As a medical lab technician, I want to record the samples collected in the scope of a given test.|
| US5 | When sampling (blood or swab) the medical lab technician records the samples in the system.|
| US6 | Courrier takes the sample in the Laboratory and delivers to company's headquarters, where the chimical laboratory is located.|
| US7 | At the company's headquarters, the clinical chemistry technologist receives the samples (delivered by a courier) and performs the chemical analysis.|
| US8 | The Clinical chemistry technologist recordes the results in the software application.|
| US9 | After completing the chemical analysis, the results of all chemical analyses are analysed by a specialist doctor who makes a diagnosis and writes a report that afterwards will be delivered to the client.|
| US10 | To facilitate and simplify the validation work performed by the specialist doctor, the application uses an external module that is responsible for doing an automatic validation using test reference values.|
| US11 | After the specialist doctor has completed the diagnosis, the results of the clinical analyses and the report become available in the system and must be validated by the laboratory coordinator. To validate the work done, the laboratory coordinator checks the chemical test/result and associated diagnosis made and confirms that everything was done correctly.|
| US12 | Once the laboratory coordinator confirms that everything was done correctly, the client receives a notification alerting that the results are already available in the central application and informing that he/she must access the application to view those results. The client receives the notification by SMS and e-mail.|
| US13 | The results are also available in the central application where the medical lab technicians who collect the samples, the clinical chemistry technologist, the specialist doctor, and the laboratory coordinator can check them.|
| US14 | To facilitate the access to the results, the application must allow ordering the clients by TIF and by name. The ordering algorithm to be used by the application must be defined through a configuration file. It is intended that the choice of the ordering algorithm is based on the algorithm complexity (mainly the execution time). Therefore, at least two sorting algorithms should be evaluated and documented in the application user manual (in the annexes) that must be delivered with the application.|
| US15 | Moreover, Many Labs is a company that needs to be continuously evaluating and improving its internal processes to achieve excellence and to beat the competition. Therefore, the company wants to decrease the number of tests waiting for its result.|
| US16 | Considering that Many Labs has the exclusivity to perform Covid-19 tests, and that the contract with the NHS in England requires Many Labs to summarize and report Covid-19 data, the company needs to: identify the number of Covid-19 tests performed, identify all positive results to Covid-19 tests, report the total number of Covid-19 cases per day, per week and per month of the year, and send the forecasts for these same time horizons (the number of Covid-19 cases for the following day, next week and next month). The company is also required to generate daily (automatic) reports with all the information demanded by the NHS and should send them to the NHS using their API.|
| US17 | As an administrator, I want to specify a new type of test and its collecting methods.|
| US18 | As an administrator, I want to specify a new test parameter and categorize it.|
| US19 | As an administrator, I want to specify a new parameter category.|