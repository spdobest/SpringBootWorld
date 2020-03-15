package spring.world.SpringMicroServices1.model;

import java.util.List;

public class CatalogResponse {
    private List<CatalogItem> listCatalog;

    public List<CatalogItem> getListCatalog() {
        return listCatalog;
    }

    public CatalogResponse() {
       super();
    }

    public void setListCatalog(List<CatalogItem> listCatalog) {
        this.listCatalog = listCatalog;
    }
}
