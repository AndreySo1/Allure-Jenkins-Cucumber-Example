### Example for Jenkins
#### Allure+Cucumber+TestNG

Steps: 
- install Jenkins+maven
- install jenkins plugin: allure
- create job-item:  \
Insert git repository link \
Build Steps: Invoke top-level Maven targets -> clean test \
Post-build Actions: Allure Report -> insert report folder(default: target/allure-results.) \
Save
