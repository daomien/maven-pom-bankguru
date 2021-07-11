package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${env}.properties"})
public interface Environement extends Config {
	String url();
	@Key("db.url")
	String getDBHostName();
	
	@Key("db.username")
	String getDBUserName();
	
	@Key("db.password")
	String getDBPassword();	
}
