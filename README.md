
spring-dynamodb-s3-ec2-codedeploy-pipeline project

This is a model project that builds a Spring Boot multi-module app that is to be uploaded to a
AWS S3 bucket and run on a AWS EC2 virual server. The application is to perform CRUD operations
using REST endpoints. In addition, the Spring boot application is to use AWS DynamoDB to maintain
retaurant orders data. The REST endpoints are located in the aws-dynamodb-multimodule-api-web module.

Requirements: To build and run the application you will need:
JDK 17
Gradle 7.4,
AWS Account Access,
a AWS accesskey
a AWS secretkey
a DynamdoDB Orders table
AWS Cli

Dynamodb Orders table:
Instructions to create the DynamoDB table with some sample data using AWS cli are detailed below:

Step 1:
AWS CLI installation and Pre-requistes:
a. Install Amazon CLI for windows
Refer to https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html

b. Configuring a AWS Access and Security key and the profile setup
Refer to https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html#cli-configure-quickstart-config

Use aws-configure to configure the proper settings to allow the AWS Command Line Interface (AWS CLI)
to interact with AWS.

Enable the auto-prompt for the AWS CLI version. aws_cli_auto_prompt=on

$ aws-configure
AWS Access Key ID [None]: AKIAIOSFODNN7EXAMPLE
AWS Secret Access Key [None]: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
Default region name [None]: us-west-2 Default output format [None]: json
Note: Your access key id, secret access key and default region most likely will be different than
these values.

d. Enviornment variable setup
Refer to: https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-envvars.html

Step 2.
Create an Orders table in AWS DynamoDB using AWS Cli commands:
git status
Scripts to help create the table with some sample data are located in the
this repo in the aws-dynamodb-multimodule-Table Script directory

Navigate to the aws-Dynamodb-Table Script directory where the scripts are located. Use a
windows powershell command window to execute the following scripts/command lines.
Make sure the you are the same directory where the scripts are located when running the command lines.

a. Run the AWS Orders table creation script command
aws dynamodb create-table --cli-input-json file://1.Order_Table_Creation_JSON_Script.json

b. Run the AWS data insertion script command
aws dynamodb batch-write-item --request-items file://3.dynamodb_table_value_insert_dml_JSON_script.json

c. Verify the dynamodb Orders table values using the AWS Management console
Go to DynamoDB->Table->Explore items. Then click on Order to view the table and items/records created.

d. Verify the DynamoDB table values using AWS Cli.
Run the scripts from a power shell window in the same directory where the scripts are located.

-- To Fetch All the records in a table
aws dynamodb execute-statement --statement "SELECT \* FROM Orders"

-- To Fetch a particular record in a table.
aws dynamodb execute-statement --statement "SELECT \* FROM Orders where id='V100'"

Step 3:
Successfully build the spring boot application using the following Gradle commands:
./gradlew clean
./gradlew build

Gradle is the main tool for build & dependency management. You will be able to run gradle commands
via the gradle wrapper in the root of this project, e.g. ./gradlew tasks

./gradlew clean - Deletes the build directory.
/gradlew build - Assembles, builds, and tests this project.

Once you have your AWS access id, AWS secret key, successfuly run aws_configure, created the
dynamoDB Orders table with sample data for the table, and successfuly built the application using the
gradle commands, navigate to the documentation folder in this repository for additional instructions
on how to upload your app to AWS S3 and setup the Code Deploy and CodePipeline for your application.
See document: AWSDocumentation17version.docx

