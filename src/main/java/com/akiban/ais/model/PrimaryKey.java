/**
 * Copyright (C) 2011 Akiban Technologies Inc.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses.
 */

package com.akiban.ais.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrimaryKey implements Serializable
{
    public List<Column> getColumns()
    {
        if (columns == null) {
            columns = new ArrayList<Column>();
            for (IndexColumn indexColumn : index.getColumns()) {
                columns.add(indexColumn.getColumn());
            }
        }
        return columns;
    }

    public Index getIndex()
    {
        return index;
    }

    public PrimaryKey()
    {
        // GWT: needs default constructor
    }

    public PrimaryKey(Index index)
    {
        this.index = index;
    }

    private Index index;
    private List<Column> columns;
}
