package co.pablobastidasv.demo

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasComponents

inline fun HasComponents.add(component: () -> Component){
    add(component.invoke())
}