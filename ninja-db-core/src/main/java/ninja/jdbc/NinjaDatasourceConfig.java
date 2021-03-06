/**
 * Copyright (C) 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ninja.jdbc;

import java.util.Optional;

public class NinjaDatasourceConfig {

    private final String name;
    private final String driver;

    private final String jdbcUrl;
    private final String username;
    private final String password;
    
    private final Optional<MigrationConfiguration> migrationConfiguration;
    
    public NinjaDatasourceConfig(
            String name, 
            String driver, 
            String jdbcUrl, 
            String username, 
            String password, 
            Optional<MigrationConfiguration> migrationConfiguration) {

        this.name = name;
        this.driver = driver;
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
        
        this.migrationConfiguration = migrationConfiguration;
    }

    public String getName() {
        return name;
    }

    public String getDriver() {
        return driver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public Optional<MigrationConfiguration> getMigrationConguration() {
        return this.migrationConfiguration;
    }

    public static class MigrationConfiguration {
        
        private final String migrationUsername;
        private final String migrationPassword;

        public MigrationConfiguration(String migrationUsername, String migrationPassword) {
            this.migrationUsername = migrationUsername;
            this.migrationPassword = migrationPassword;
        }

        public String getMigrationUsername() {
            return migrationUsername;
        }

        public String getMigrationPassword() {
            return migrationPassword;
        }

    }
    
    
}
