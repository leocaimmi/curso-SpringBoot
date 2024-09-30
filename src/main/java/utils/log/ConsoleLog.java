package utils.log;



import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("consoleLog")
public class ConsoleLog implements Log{
    private final Logger logger = LoggerFactory.getLogger(ConsoleLog.class);
    @Override
    public void registrarAccion(CodigoLog codigoLog){
        logger.info("Accion "+codigoLog.getCodigo() +" - "+codigoLog.getDescripcion());
    }
}
