markdown
Copy code
# Dynamic PDF Generator

A simple project that generates a PDF for invoice details provided in a fixed format.

## Setup

To set up the project, follow these steps:

### Clone the Repository

Clone the repository on your local computer using the following command:

```
   git clone https://github.com/naveen106/DynamicPDFGenerator.git
```

Alternatively, you can also download the `zip` file by clicking the `Code` button dropdown and selecting `Download ZIP`.

### Running the Project

Run the `PdfGeneratorApplication.java` file to start the project.

### Testing the API

To test the API from your localhost, follow these steps:

1. After running the application, access the Swagger-UI by visiting the following URL: `localhost:8080/swagger-ui.html`.

2. Alternatively, you can test it using the Postman agent on your local computer by making a POST request to the following URL: `localhost:8080/pdf/generate`.

3. Use the provided raw JSON data format as the request body. Here's an example:

```json
{
    "seller": "XYZ Pvt. Ltd.",
    "sellerGstIn": "29AABBCCDD121ZD",
    "sellerAddress": "New Delhi, India",
    "buyer": "Vedant Computers",
    "buyerGstIn": "29AABBCCDD131ZD",
    "buyerAddress": "New Delhi, India",
    "items": [
        {
            "name": "Product 1",
            "quantity": "12 Nos",
            "rate": 123.00,
            "amount": 1476.00
        }        
    ]
}
```
Upon sending the POST request with the specified data format, you should receive a generated PDF invoice as the response.