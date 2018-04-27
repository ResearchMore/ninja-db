/**
 * Copyright (C) 2017-2018 the original author or authors.
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

package ninja.jdbi;

import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ninja.jdbc.NinjaDatasource;
import ninja.jdbc.NinjaDatasources;
import org.skife.jdbi.v2.DBI;

public class NinjaJdbiImpl implements NinjaJdbi {

    final Map<String, DBI> nameToDBIMap;

    public NinjaJdbiImpl(NinjaDatasources ninjaDatasources) {

        Map<String, DBI> map = new HashMap<>();

        for (NinjaDatasource ninjaDatasource : ninjaDatasources.getDatasources()) {
            DBI dbi = new DBI(ninjaDatasource.getDataSource());
            map.put(ninjaDatasource.getName(), dbi);
        }

        this.nameToDBIMap = ImmutableMap.copyOf(map);
    }

    @Override
    public DBI getDbi(String datasourceName) {
        return nameToDBIMap.get(datasourceName);
    }

}
