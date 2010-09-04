/**
 * Copyright (C) 2010 Orbeon, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
 */
package org.orbeon.oxf.xforms.analysis.controls;

import org.dom4j.Element;
import org.dom4j.QName;
import org.orbeon.oxf.util.PropertyContext;
import org.orbeon.oxf.xforms.XFormsStaticState;
import org.orbeon.oxf.xforms.analysis.XPathAnalysis;
import org.orbeon.oxf.xforms.xbl.XBLBindings;
import org.orbeon.saxon.dom4j.DocumentWrapper;

import java.util.Map;

public class ComponentAnalysis extends ContainerAnalysis {
    public ComponentAnalysis(PropertyContext propertyContext, XFormsStaticState staticState, DocumentWrapper controlsDocumentInfo,
                             XBLBindings.Scope scope, Element element, int index, boolean isValueControl, ContainerAnalysis parentControlAnalysis,
                             Map<String, SimpleAnalysis> inScopeVariables) {
        super(propertyContext, staticState, controlsDocumentInfo, scope, element, index, isValueControl, parentControlAnalysis, inScopeVariables);
    }

    @Override
    protected Element findNestedLHHAElement(PropertyContext propertyContext, DocumentWrapper controlsDocumentInfo, QName qName) {
        // Nested LHHA elements are handled by XBL template
        return null;
    }

    @Override
    public XPathAnalysis computeBindingAnalysis(Element element) {
        // TODO: TEMP: Control does not have a binding. But return one anyway so that controls w/o their own binding also get updated.
        return findOrCreateBaseAnalysis(parentAnalysis());
    }

    @Override
    public XPathAnalysis computeValueAnalysis() {
        return null;
    }
}
