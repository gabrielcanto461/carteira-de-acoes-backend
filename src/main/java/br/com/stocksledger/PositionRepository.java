package br.com.stocksledger;

import br.com.stocksledger.model.AverageAndInvestedAmount;
import br.com.stocksledger.model.Position;
import br.com.stocksledger.model.PositionDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {

    List<Position> findAllByTickerIgnoreCase(String ticker);

    @Query("SELECT new br.com.stocksledger.model.PositionDetailDTO(" +
            "p.ticker, " +
            "SUM(p.quantity), " +
            "AVG(p.price), " +
            "SUM(p.price * p.quantity)) " +
            "FROM Position p GROUP BY p.ticker")
    List<PositionDetailDTO> findPositionDetail();

}
