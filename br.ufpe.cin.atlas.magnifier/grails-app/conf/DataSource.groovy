dataSource {
	//# Default
	/*
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
    //*/
	
	//# MySQL
	//*
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	//*/
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			//# Default
			/*
			url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			//*/
			
			//# Local MySQL
			/*
			url = "jdbc:mysql://localhost/atlas?useUnicode=yes&characterEncoding=UTF-8"
			username = "root"
			password = "root"
			//*/
			
			//# Cloudbees MySQL
			//*
			url = "jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com:3306/atlas?useUnicode=yes&characterEncoding=UTF-8"
			username = "netuh"
			password = "pass1234"
			//*/
        }
    }
    test {
        dataSource {
			//# Default
            /*
			dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			dbCreate = "update"
			//*/
			
			//# Local MySQL
			/*
			url = "jdbc:mysql://localhost/atlas_prod?useUnicode=yes&characterEncoding=UTF-8"
			username = "root"
			password = "root"
			//*/
			
			//# Cloudbees MySQL
			//*
			dbCreate = "update"
			url = "jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com:3306/atlas?useUnicode=yes&characterEncoding=UTF-8"
			username = "netuh"
			password = "pass1234"
			//*/
        }
    }
    production {
        dataSource {
			//# Local MySQL
			/*
			dbCreate = "update"
			url = "jdbc:mysql://localhost/atlas_prod?useUnicode=yes&characterEncoding=UTF-8"
			username = "root"
			password = "root"
			//*/
			
			//# Cloudbees MySQL
			//*
			dbCreate = "update"
			url = "jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com:3306/atlas?useUnicode=yes&characterEncoding=UTF-8"
			username = "netuh"
			password = "pass1234"
			//*/
			
			//# Default
			/*
			dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=false
               validationQuery="SELECT 1"
               jdbcInterceptors="ConnectionState"
            }
            //*/
        }
    }
}
