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

package com.akiban.cserver.api.dml.scan;

import java.nio.ByteBuffer;

import com.akiban.util.ArgumentValidation;

public class WrappingRowOutput implements LegacyRowOutput {
    protected final ByteBuffer wrapped;
    private int rows;

    /**
     * Creates a RowOutput that returns the given ByteBuffer
     * @param buffer the ByteBuffer to wrap
     * @throws IllegalArgumentException is buffer if null
     */
    public WrappingRowOutput(ByteBuffer buffer) {
        ArgumentValidation.notNull("buffer", buffer);
        this.wrapped = buffer;
    }

    @Override
    final public ByteBuffer getOutputBuffer() throws RowOutputException {
        return wrapped;
    }

    @Override
    final public void wroteRow() throws RowOutputException {
        ++rows;
        postWroteRow();
    }

    protected void postWroteRow() throws RowOutputException {

    }

    @Override
    final public int getRowsCount() {
        return rows;
    }
}
