Title: Blog-JEE

Blog-JEE is a sample application employing some JEE technologies, such as EJB, JPA, JSF, CDI.

## Quick start

Clone project:

	git clone git://github.com/neigroove/blog-jee.git

To test it:

On root application blog-jee:
	
	mvn clean install

On web module blog-jee/blog-jee-web

    mvn clean package tomee:run

## How does it work?

A datasource is defined in tomee.xml:

    <Resource id="blog-jee-ds" type="DataSource" />
    
Blog uses DB (HSQLDB) in memory.

Then this datasource is referenced in server.xml:

To initialize the datasource (for the test) it's used EJB (br.com.flanders.blogjee.web.listener.BlogDataLoader)
. It simply inserts some posts and the user "admin" with the password "admin".

## Test it

Go to http://localhost:8080/blog-jee-web-1.0-SNAPSHOT/

Connect using the login/password admin/admin. You should see the posts.