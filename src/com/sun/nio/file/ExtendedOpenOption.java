/*
 * Copyright (c) 2007, 2017, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.nio.file;

import java.nio.file.OpenOption;
import sun.nio.fs.ExtendedOptions;

/**
 * Defines <em>extended</em> open options supported on some platforms by Sun's provider implementation.
 *
 * @since 1.7
 */
// 文件创建/打开操作的扩展可选参数
public enum ExtendedOpenOption implements OpenOption {
    
    /**
     * Prevent operations on the file that request read access.
     */
    // 阻止共享读操作
    NOSHARE_READ(ExtendedOptions.NOSHARE_READ),
    
    /**
     * Prevent operations on the file that request write access.
     *
     */
    // 阻止共享写操作
    NOSHARE_WRITE(ExtendedOptions.NOSHARE_WRITE),
    
    /**
     * Prevent operations on the file that request delete access.
     */
    // 阻止共享删除操作
    NOSHARE_DELETE(ExtendedOptions.NOSHARE_DELETE),
    
    /**
     * Requires that direct I/O be used for read or write access.
     * Attempting to open a file with this option set will result in
     * an {@code UnsupportedOperationException} if the operating system or
     * file system does not support Direct I/O or a sufficient equivalent.
     *
     * @apiNote
     * The DIRECT option enables performing file I/O directly between user
     * buffers and the file thereby circumventing the operating system page
     * cache and possibly avoiding the thrashing which could otherwise occur
     * in I/O-intensive applications. This option may be of benefit to
     * applications which do their own caching or do random I/O operations
     * on large data sets. It is likely to provide the most benefit when
     * the file is stored on a device which has high I/O throughput capacity.
     * The option should be used with caution however as in general it is
     * likely to degrade performance. The performance effects of using it
     * should be evaluated in each particular circumstance.
     *
     * @since 10
     */
    // 使用直接IO
    DIRECT(ExtendedOptions.DIRECT);
    
    ExtendedOpenOption(ExtendedOptions.InternalOption<Void> option) {
        option.register(this);
    }
}
