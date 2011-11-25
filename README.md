# Run project

	mvn jetty:run
	
# Debug project
	./debug-jetty.sh
Connect to port 4000 as a remote application

# Test
	GET http://localhost:8080/primavera/booksearch/authors.xml
	GET http://localhost:8080/primavera/booksearch/books.json
	
## POST JSON
    {
    "isbn": "asdfghjkl",
    "title": "Thiago Caiubi",
    "edition": 1234,
    "pages": 23,
    "published": "SCCP 1910",
    "authors": [
        {
            "authorId": "QWERTYUIOP",
            "name": "Thiago Caiubi",
            "email": "thiago.caubi@xpto.com"
        }
    ],
    "publisher": {
        "name": "Thiago Caiubi",
        "address": {
            "address": "Rua da Praia, 1",
            "city": "Florianópolis",
            "state": "SC",
            "zip": "04525-023"
        }
    }


# Credits
	The base of this project was extract from http://www.stupidjavatricks.com/?p=54
