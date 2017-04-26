# aon-insurance

Steps to launch and test:-

1. use maven to build the application . [mvn clean install]
2. run InsuranceApp.java as a springboot application
3. open the browser and use the url :-

URI :- http://localhost:8080/quotes?postcode=2000&occupation=Builder&turnover=600000
Result:
[
  {
    "name": "insurer1",
    "price": 100
  },
  {
    "name": "insurer3",
    "price": 1007
  },
  {
    "name": "insurer2",
    "price": 1000
  },
  {
    "name": "insurer4",
    "price": 10000
  }
]

4. Change the parameters of postcode,occupation and turnover to see the different results.
