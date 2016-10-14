<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900"
	rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->

</head>
<body>
	<form action="First" method="post">
		<div id="wrapper">
			<div id="header-wrapper">
				<div id="header" class="container">
					<div id="logo">
						<h1>
							<a href="#">Java Recommender</a>
						</h1>
						<p>
							Design by <a href="http://templated.co" rel="nofollow">Stackoverflow.com
								Recommendations</a>
						</p>
					</div>

				</div>
				<div id="menu" class="container">
					<ul>
						<li class="current_page_item"><a href="#" accesskey="1"
							title="">Homepage</a></li>
						<li><a href="Explanation.jsp" accesskey="1" title="">Explanation</a></li>
					</ul>
				</div>
			</div>
			<br>
			<div>
				<button class="crawl" name="crawl" value="crawl">Crawl</button>
				<div id="page" class="container">
					<div id="content">
						<div class="post">
							<h4>Post 1</h4>
							<p>
								<button class="link"
									value="One way to implement deep copy is to add copy constructors to each associated class. A copy constructor takes an instance of 'this' as its single argument and copies all the values from it. Quite some work, but pretty straightforward and safe. EDIT: note that you don't need to use accessor methods to read fields. You can access all fields directly because the source instance is always of the same type as the instance with the copy constructor. Obvious but might be overlooked. Example Edit Note that when using copy constructors you need to know the runtime type of the object you are copying. With the above approach you cannot easily copy a mixed list (you might be able to do it with some reflection code"
									name="post">One way to implement deep copy is to add
									copy constructors to each associated class. A copy constructor
									takes an instance of 'this' as its single argument and copies
									all the values from it. Quite some work, but pretty
									straightforward and safe. EDIT: note that you don't need to use
									accessor methods to read fields. You can access all fields
									directly because the source instance is always of the same type
									as the instance with the copy constructor. Obvious but might be
									overlooked. Example: Edit: Note that when using copy
									constructors you need to know the runtime type of the object
									you are copying. With the above approach you cannot easily copy
									a mixed list (you might be able to do it with some reflection
									code</button>
							</p>
							<!--<p>One way to implement deep copy is to add copy constructors to each associated class. A copy constructor takes an instance of 'this' as its single argument and copies all the values from it. Quite some work, but pretty straightforward and safe. EDIT: note that you don't need to use accessor methods to read fields. You can access all fields directly because the source instance is always of the same type as the instance with the copy constructor. Obvious but might be overlooked. Example: Edit: Note that when using copy constructors you need to know the runtime type of the object you are copying. With the above approach you cannot easily copy a mixed list (you might be able to do it with some reflection code</p>-->
						</div>
						<div class="post">
							<h2>Post 2</h2>
							<p>
								<button class="link"
									value="I was presented with this question in an end of module open book exam today and found myself lost. i was reading Head first Javaand both definitions seemed to be exactly the same. i was just wondering what the MAIN difference was for my own piece of mind. i know there are a number of similar questions to this but, none i have seen which provide a definitive answer.Thanks, Darren"
									name="post">I was presented with this question in an
									end of module open book exam today and found myself lost. i was
									reading Head first Javaand both definitions seemed to be
									exactly the same. i was just wondering what the MAIN difference
									was for my own piece of mind. i know there are a number of
									similar questions to this but, none i have seen which provide a
									definitive answer.Thanks, Darren</button>
							</p>
						</div>
						<div class="post">
							<h2>Post 3</h2>
							<p>
								<button class="link"
									value="Inheritance is when a 'class' derives from an existing 'class'.So if you have a Person class, then you have a Student class that extends Person, Student inherits all the things that Person has.There are some details around the access modifiers you put on the fields/methods in Person, but that's the basic idea.For example, if you have a private field on Person, Student won't see it because its private, and private fields are not visible to subclasses.Polymorphism deals with how the program decides which methods it should use, depending on what type of thing it has.If you have a Person, which has a read method, and you have a Student which extends Person, which has its own implementation of read, which method gets called is determined for you by the runtime, depending if you have a Person or a Student.It gets a bit tricky, but if you do something likePerson p = new Student();p.read();the read method on Student gets called.Thats the polymorphism in action.You can do that assignment because a Student is a Person, but the runtime is smart enough to know that the actual type of p is Student.Note that details differ among languages.You can do inheritance in javascript for example, but its completely different than the way it works in Java."
									name="post">Inheritance is when a 'class' derives from
									an existing 'class'.So if you have a Person class, then you
									have a Student class that extends Person, Student inherits all
									the things that Person has.There are some details around the
									access modifiers you put on the fields/methods in Person, but
									that's the basic idea.For example, if you have a private field
									on Person, Student won't see it because its private, and
									private fields are not visible to subclasses.Polymorphism deals
									with how the program decides which methods it should use,
									depending on what type of thing it has.If you have a Person,
									which has a read method, and you have a Student which extends
									Person, which has its own implementation of read, which method
									gets called is determined for you by the runtime, depending if
									you have a Person or a Student.It gets a bit tricky, but if you
									do something likePerson p = new Student();p.read();the read
									method on Student gets called.Thats the polymorphism in
									action.You can do that assignment because a Student is a
									Person, but the runtime is smart enough to know that the actual
									type of p is Student.Note that details differ among
									languages.You can do inheritance in javascript for example, but
									its completely different than the way it works in Java.</button>
							</p>
						</div>
						<div class="post">
							<h2>Post 4</h2>
							<p>
								<button class="link" name="post"
									value="Polymorphism The ability to treat objects of different types in a similar manner.Example: Giraffe and Crocodile are both Animals, and animals can Move.If you have an instance of an Animal then you can call Move without knowing or caring what type of animal it is.Inheritance: This is one way of achieving both Polymorphism and code reuse at the same time.Other forms of polymorphism:There are other way of achieving polymorphism, such as interfaces, which provide only polymorphism but no code reuse (sometimes the code is quite different, such as Move for a Snake would be quite different from Move for a Dog, in which case an Interface would be the better polymorphic choice in this case.In other dynamic languages polymorphism can be achieved with Duck Typing, which is the classes don't even need to share the same base class or interface, they just need a method with the same name.Or even more dynamic like Javascript, you don't even need classes at all, just an object with the same method name can be used polymorphically">Polymorphism:
									The ability to treat objects of different types in a similar
									manner.Example: Giraffe and Crocodile are both Animals, and
									animals can Move.If you have an instance of an Animal then you
									can call Move without knowing or caring what type of animal it
									is.Inheritance: This is one way of achieving both Polymorphism
									and code reuse at the same time.Other forms of
									polymorphism:There are other way of achieving polymorphism,
									such as interfaces, which provide only polymorphism but no code
									reuse (sometimes the code is quite different, such as Move for
									a Snake would be quite different from Move for a Dog, in which
									case an Interface would be the better polymorphic choice in
									this case.In other dynamic languages polymorphism can be
									achieved with Duck Typing, which is the classes don't even need
									to share the same base class or interface, they just need a
									method with the same name.Or even more dynamic like Javascript,
									you don't even need classes at all, just an object with the
									same method name can be used polymorphically</button>
							</p>
						</div>
						<div class="post">
							<h2>Post 5</h2>
							<p>
								<button class="link" name="post"
									value="I found out that the above piece of code is perfectly legal in Java. I have the following questions. ThanksAdded one more question regarding Abstract method classes">I
									found out that the above piece of code is perfectly legal in
									Java. I have the following questions. ThanksAdded one more
									question regarding Abstract method classes</button>
							</p>
						</div>
						<div class="post">
							<h2>Post 6</h2>
							<p>
								<button class="link" name="post"
									value="Can Inner class access instance variables of outer class?">Can
									Inner class access instance variables of outer class?</button>
							</p>
						</div>
						<div class="post">
							<h2>Post 7</h2>
							<p>
								<button class="link" name="post"
									value="You can make a deep copy serialization without creating some files. Copy: Restore:">You
									can make a deep copy serialization without creating some files.
									Copy: Restore:</button>
							</p>
						</div>
						<div class="post">
							<div class="post-title">
								<h2>Post 8</h2>
							</div>
							<p>
								<button class="link" name="post"
									value="Java has the ability to create classes at runtime. These classes are known as Synthetic Classes or Dynamic Proxies. See for more information. Other open-source libraries, such as and also allow you to generate synthetic classes, and are more powerful than the libraries provided with the JRE. Synthetic classes are used by AOP (Aspect Oriented Programming) libraries such as Spring AOP and AspectJ, as well as ORM libraries such as Hibernate.">
									Java has the ability to create classes at runtime. These
									classes are known as Synthetic Classes or Dynamic Proxies. See
									for more information. Other open-source libraries, such as and
									also allow you to generate synthetic classes, and are more
									powerful than the libraries provided with the JRE. Synthetic
									classes are used by AOP (Aspect Oriented Programming) libraries
									such as Spring AOP and AspectJ, as well as ORM libraries such
									as Hibernate.</button>
							</p>
						</div>

						<div class="post">
							<div class="post-title">
								<h2>Post 9</h2>
							</div>
							<p>
								<button class="link" name="post"
									value="In short: the web server issues a unique identifier to on his visit. The visitor must bring back that ID for him to be recognised next time around. This identifier also allows the server to properly segregate objects owned by one session against that of another. If is: If is: Once he's on the service mode and on the groove, the servlet will work on the requests from all other clients.Why isn't it a good idea to have one instance per client? Think about this: Will you hire one pizza guy for every order that came? Do that and you'd be out of business in no time. It comes with a small risk though. Remember: this single guy holds all the order information in his pocket: so if you're not cautious about, he may end up giving the wrong order to a certain client">
									In short: the web server issues a unique identifier to on his
									visit. The visitor must bring back that ID for him to be
									recognised next time around. This identifier also allows the
									server to properly segregate objects owned by one session
									against that of another. If is: If is: Once he's on the service
									mode and on the groove, the servlet will work on the requests
									from all other clients.Why isn't it a good idea to have one
									instance per client? Think about this: Will you hire one pizza
									guy for every order that came? Do that and you'd be out of
									business in no time. It comes with a small risk though.
									Remember: this single guy holds all the order information in
									his pocket: so if you're not cautious about, he may end up
									giving the wrong order to a certain client</button>
							</p>
						</div>

						<div class="post">
							<div class="post-title">
								<h2>Post 10</h2>
							</div>
							<p>
								<button class="link" name="post"
									value="A safe way is to serialize the object, then deserialize.This ensures everything is a brand new reference.about how to do this efficiently. Caveats: It's possible for classes to override serialization such that new instances are created, e.g. for singletons.Also this of course doesn't work if your classes aren't Serializable.">
									A safe way is to serialize the object, then deserialize.This
									ensures everything is a brand new reference.about how to do
									this efficiently. Caveats: It's possible for classes to
									override serialization such that new instances are created,
									e.g. for singletons.Also this of course doesn't work if your
									classes aren't Serializable.</button>
							</p>
						</div>




					</div>





					<div id="sidebar1">
						<div>
							<h2>Recommendations</h2>
							<% %>
							<%  
		
		List<String> list = (ArrayList<String>) request.getAttribute("message1");
		ArrayList<String> keyList = (ArrayList<String>) request.getAttribute("keywrods");
		if(list != null)
		{
			
		for(int i=0; i< list.size()-3; i=i+3) {	
		%>
							<ul class="style2">
								<li class="first">
									<h3>
										<a href=<%=list.get(i)%>><%=list.get(i) %></a>
									</h3> <strong><%=list.get(i+1)%></strong>
									<p><%=list.get(i+2)%></p> <% 	}}
		%>

								</li>
							</ul>
							<p>
								<strong>Stemmed Keywords</strong>
							</p>

							<p>
								<strong>${keywords}</strong>
							</p>

							</ul>

						</div>

					</div>
				</div>
			</div>
			<div id="footer">
				<p>
					&copy; Saurabh Kardile. All rights reserved. Design by <a href=""
						rel="nofollow">Kardile and Sons.</a>. Photos by <a href=""></a>.
				</p>
			</div>
	</form>
</body>
</html>