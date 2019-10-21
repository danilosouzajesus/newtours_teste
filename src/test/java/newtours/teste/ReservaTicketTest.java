package newtours.teste;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import newtours.pageobject.BookFlight;
import newtours.pageobject.ConfirmFlight;
import newtours.pageobject.Home;
import newtours.pageobject.SearchFlight;
import newtours.pageobject.SelectFlight;

public class ReservaTicketTest {
	
	private WebDriver driver;
	private Scenario scenario;
	
	@Before()
    public void getScenario(Scenario scenario) {
		this.scenario= scenario;
    }

	@Dado("^que eu esteja na pagina inicial do site$")
	public void que_eu_esteja_na_pagina_inicial_do_site() throws Throwable {
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
	    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    driver.get("http://newtours.demoaut.com");
	}

	@Dado("^eu logo com um usuario se senha validos$")
	public void eu_logo_com_um_usuario_se_senha_validos() throws Throwable {
	    Home home = new Home(driver, scenario);
	    home.doLogin("mercury", "mercury");
	}

	@Quando("^eu procuro um voo com os dados definidos$")
	public void eu_procuro_um_voo_com_os_dados_definidos() throws Throwable {
		SearchFlight search = new SearchFlight(driver,scenario);
		Calendar mCalendar = Calendar.getInstance();    
		String month = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		String day = mCalendar.get(Calendar.DAY_OF_MONTH) + "";
		search.searchFlight(1, "London", "Paris", month, day, "first");
	}

	@Quando("^seleciono o voo desejado$")
	public void seleciono_o_voo_desejado() throws Throwable {
		SelectFlight selectF = new SelectFlight(driver,scenario);
		selectF.selectFlight("Unified Airlines 363");
	}
	
	@Quando("^informo os dados de pagamento e dos passageiros$")
	public void informo_os_dados_de_pagamento_e_dos_passageiros() throws Throwable {
		BookFlight book = new BookFlight(driver,scenario);
		book.bookFlight("Danilo", "Jesus", "123456");
	}

	@Entao("^o numero do ticket é gerado$")
	public void o_numero_do_ticket_é_gerado() throws Throwable {
		ConfirmFlight confirmation = new ConfirmFlight(driver,scenario);
	    System.out.println(confirmation.getFlightConfirmation());
	    driver.close();
	}
	
}
