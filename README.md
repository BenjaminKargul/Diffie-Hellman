# Diffie-Hellman
CS 5490/6490: Network Security – Fall 2017
Programming Assignment 2
Due by 11:59 PM MT, Friday September 15th 2017
• No cheating will be tolerated. No copying from the Internet is allowed.
• No extensions will be granted.
• The code and the output files must be submitted using the handin utility in the
directory PA2-17.
• Total Points = 30
Write a program (in C, C++, C#, Python, or Java), call it EXPO, to efficiently
exponentiate big numbers modulo n as described in Section 6.3.4.1 of your textbook.
Your program should take three positive numbers as input, one representing the number
m, another representing the exponent d to which m is raised to and the third being n.
Write client server programs (in C, C++, C#, Python, or Java) using TCP sockets where
the client (Alice) and the server (Bob) perform a Diffie Hellman exchange. Use your
EXPO program (or function call) to compute the Diffie Hellman numbers. Let g = 1907,
p = 784313, SA = 160011 (Alice’s secret), and SB = 12067 (Bob’s secret). Your ouput
must show the numbers sent by Alice and Bob for the Diffie Hellman exchange as well
the shared key after the exchange.
Using the handin utility (cs5490 students should also use cs6490), electronically turn in
your code along with the output files. While you can use any computer to work on your
programs, make sure that these run on the CADE lab machines. We cannot grade any
programs that do not run on the CADE lab machines. VERY IMPORTANT: Please
provide a short readme file with any instructions to run your programs on the CADE
machines. The handin directory for this assignment is PA2-17 (do not use just PA2 which
is an old directory).
