<h1>Project description</h1>
<h2>How to start application</h2>
<h3>Get Gmail with secure app password</h3>
<p>I recommend to create a new gmail account for this application.<br/> 
1. Go to <a href="https://myaccount.google.com">myaccount.google.com</a> <br/>
2. Go to Security.
  
  ![image](https://github.com/OleksandrOrlovIT/CityCountryEmailSender/assets/86959421/7266123b-979d-4258-8c51-eab95d1becdf)
3. Enable 2-Step Verification
![image](https://github.com/OleksandrOrlovIT/CityCountryEmailSender/assets/86959421/3939bedd-5a1d-4418-b522-0960263f6998)
4. After enabling 2-Step Verification go to the <a href="https://myaccount.google.com/u/0/apppasswords">https://myaccount.google.com/u/0/apppasswords</a> and create a password for less secure apps. Save it somewhere for later use. 
![image](https://github.com/OleksandrOrlovIT/CityCountryEmailSender/assets/86959421/dc8dc4b6-ab76-4ba2-be1f-9a2c9b6a83d0)
</p>
<h3>How to load application</h3>
<p>
  1. Clone the app

  ![image](https://github.com/OleksandrOrlovIT/CityCountryEmailSender/assets/86959421/49322916-c926-455a-a9ca-23ad02874c43)

  2. In root project change .env file. Add Your email username in MAIL_USERNAME= and Password for less secure apps in MAIL_PASSWORD=
     ![image](https://github.com/OleksandrOrlovIT/CityCountryEmailSender/assets/86959421/8d895ac1-c902-46ac-a7c2-49236265fff0)
3. In the terminal at the project root destination type to start the program <b>docker compose up --build</b>
![image](https://github.com/OleksandrOrlovIT/CityCountryEmailSender/assets/86959421/37897e8f-5fbd-4d53-b049-5e6d88227609)
4. Wait until project will be build with message log city_country_email_sender  | 2024-06-05T20:06:39.897Z  INFO 1 --- [CityCountryEmailSender] [           main] .o.p.c.CityCountryEmailSenderApplication : Started CityCountryEmailSenderApplication in 2.846 seconds (process running for 3.642)
![image](https://github.com/OleksandrOrlovIT/CityCountryEmailSender/assets/86959421/447b95bc-1422-4865-8bfc-6570cef41dba)
5. In order to send messages via email and RabbitMQ go to the <a href="https://github.com/OleksandrOrlovIT/CityCountrySpringREST">https://github.com/OleksandrOrlovIT/CityCountrySpringREST</a> and follow next instructions.

</p>
