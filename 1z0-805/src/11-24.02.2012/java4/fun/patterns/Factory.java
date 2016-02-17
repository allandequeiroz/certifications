package java4.fun.patterns;

public class Factory {}

interface DataAccess{}
class TextFileDataAccess implements DataAccess{}
class XMLDataAccess implements DataAccess{}
class RDBMSDataAccess implements DataAccess{}

class DataAccessFactory{
    
    final int TEXT_FILE = 1;
    final int XML = 2;
    final int RDBMS = 3;
    
    public DataAccess getDataAccess(int type){
        DataAccess dataAccess = null;
        
        switch(type){
            case TEXT_FILE:dataAccess=new TextFileDataAccess();break;
            case XML:dataAccess=new XMLDataAccess();break;
            case RDBMS:dataAccess=new RDBMSDataAccess();break;
        }
        
        return dataAccess;
    }
}
