package ma.oumaimaezafa.springbatchtp.TP6_orders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionListener implements JobExecutionListener {
    private static  final Logger log= LoggerFactory.getLogger(JobCompletionListener.class);
    private  final JdbcTemplate jdbcTemplate;

    public JobCompletionListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("Job terminé ! Voici les commandes insérées :");

            jdbcTemplate.query("SELECT orderId, customerName, amount FROM orders",
                    (rs, row) -> new Order(
                            rs.getInt("orderId"),
                            rs.getString("customerName"),
                            rs.getDouble("amount")
                    )).forEach(order -> System.out.println("Transformé : " + order));
        }
    }
}
