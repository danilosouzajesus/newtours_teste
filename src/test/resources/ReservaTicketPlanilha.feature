 # language: pt
 @NewTours
 Funcionalidade: Testar a compar de tickets para voo.
 
 Cenario: Reservar Ticket
 	Dado que eu esteja na pagina inicial do site
 	E eu logo com um usuario se senha validos
 	Quando eu procuro um voo com os dados definidos
 	E seleciono o voo desejado
 	E informo os dados de pagamento e dos passageiros
 	Entao o numero do ticket é gerado
 	