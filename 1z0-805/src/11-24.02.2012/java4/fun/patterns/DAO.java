package java4.fun.patterns;


public interface DAO {
    public Object getObjectDetails(int id);
    public void setObjectDetails(Object obj);
    public void removeObject(Object obj);
}
class TextFileDAO implements DAO{
    @Override
    public Object getObjectDetails(int id) { return null; }
    @Override
    public void setObjectDetails(Object obj) {}
    @Override
    public void removeObject(Object obj) {}
}
class XMLDAO implements DAO{
    @Override
    public Object getObjectDetails(int id) { return null; }
    @Override
    public void setObjectDetails(Object obj) {}
    @Override
    public void removeObject(Object obj) {}
}
class RDBMSDAO implements DAO{
    @Override
    public Object getObjectDetails(int id) { return null; }
    @Override
    public void setObjectDetails(Object obj) {}
    @Override
    public void removeObject(Object obj) {}
}
