<h1>Demo Assessment</h1>

<h4>How to run</h4>
To run this service locally, use the following command in the root directory:<br>
<code>mvn clean spring-boot:run -Dspring-boot.run.profiles=test</code><br><br>

<h4>How to test</h4>
To run the unit- and contract-tests, run in the root directory: <br>
<code>mvn clean install</code><br><br>

To run/edit the integration tests: <br>
1. Install Postman and import the collection from <code>/test/integration</code>
2. Create an environment in Postman with the following variables:<br>
<code>baseUrl: URL you want the integration tests to run on</code><br>
3. Run the collection with the created environment.<br>
4. Edit/add desired cases and export the collection to the stated directory.<br>
5. Note: if you only want to run the tests and not edit them, you can also use the CLI tool called Newman.<br>
