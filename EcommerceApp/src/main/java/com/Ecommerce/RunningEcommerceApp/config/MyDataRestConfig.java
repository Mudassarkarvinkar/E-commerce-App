package com.Ecommerce.RunningEcommerceApp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.Ecommerce.RunningEcommerceApp.entity.Product;
import com.Ecommerce.RunningEcommerceApp.entity.ProductCategory;



@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	
	private EntityManager entityManager;
	
	@Autowired	
	public MyDataRestConfig(EntityManager theEntityManager )
	{
		entityManager = theEntityManager;
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		HttpMethod[] theUnsupportedAction = {HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.POST};
		
		config.getExposureConfiguration().forDomainType(Product.class)
		.withItemExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedAction))
		.withCollectionExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedAction));
		
		
	
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
		.withItemExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedAction))
		.withCollectionExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedAction));
	
	exposeIds(config);
	 
	}

	private void exposeIds(RepositoryRestConfiguration config) {

		Set<EntityType<?>> entities= entityManager.getMetamodel().getEntities();
		
		List<Class> entityclasses = new ArrayList<>();
		
		for(EntityType TempEntityType:  entities)
		
		{		
			entityclasses.add(TempEntityType.getJavaType());
			
		}
		Class[]	 domainTypes =entityclasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
		
	}
}
