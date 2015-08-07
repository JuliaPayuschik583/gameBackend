package game.tictactoe.security;

/**
 * @author julia
 */
//@Configuration
//@EnableWebSecurity
public class AppSecurityConfig {//extends WebSecurityConfigurerAdapter {

    //@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
//    }

    //@Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        //http.csrf().disable();
//
//        http.authorizeRequests()
//                .antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')")
//                .and().formLogin().defaultSuccessUrl("/", false);
//
//    }
}