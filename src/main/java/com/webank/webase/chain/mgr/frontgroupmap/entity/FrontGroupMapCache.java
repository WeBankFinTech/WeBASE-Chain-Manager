/**
 * Copyright 2014-2019  the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.webank.webase.chain.mgr.frontgroupmap.entity;


import com.webank.webase.chain.mgr.frontgroupmap.FrontGroupMapService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrontGroupMapCache {

    @Autowired
    private FrontGroupMapService mapService;

    private static List<FrontGroup> mapList;


    /**
     * clear mapList.
     */
    public void clearMapList() {
        mapList = null;
    }

    /**
     * reset mapList.
     */
    public List<FrontGroup> resetMapList(int chainId) {
        MapListParam param = new MapListParam();
        param.setChainId(chainId);
        mapList = mapService.getList(param);
        return mapList;
    }

    /**
     * get mapList.
     */
    public List<FrontGroup> getMapListByChainId(int chainId, int groupId) {
        List<FrontGroup> list = getAllMap(chainId);
        if (list == null) {
            return null;
        }
        List<FrontGroup> map = list.stream().filter(m -> groupId == m.getGroupId())
            .collect(Collectors.toList());
        return map;
    }

    /**
     * get all mapList.
     */
    public List<FrontGroup> getAllMap(int chainId) {
        if (mapList == null || mapList.size() == 0) {
            mapList = resetMapList(chainId);
        }
        return mapList;
    }
}
