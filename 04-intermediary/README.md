# 04-intermediary
1. Run BankService
2. Run BankServlet on Tomcat Server
3. Send request to the address `http://localhost:8080/test1/BankServlet` using SoapUI in format:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap02/">
   <soapenv:Header>
   	<tweak Fee="15" xmlns="http://tweaks.com/"/>
   </soapenv:Header>
   <soapenv:Body>
      <soap:GetBalance>
         <!--Optional:-->
         <arg0>1234567890</arg0>
         <!--Optional:-->
         <arg1>02/22</arg1>
         <!--Optional:-->
         <arg2>143</arg2>
      </soap:GetBalance>
   </soapenv:Body>
</soapenv:Envelope>
```
It will add Fee to the balance.

4. You should receive response like:
```
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Header>
      <tweaked xmlns="http://tweaks.com/">Added fee:15</tweaked>
   </S:Header>
   <S:Body>
      <ns2:GetBalanceResponse xmlns:ns2="http://soap02/">
         <return>1015</return>
      </ns2:GetBalanceResponse>
   </S:Body>
</S:Envelope>
```
