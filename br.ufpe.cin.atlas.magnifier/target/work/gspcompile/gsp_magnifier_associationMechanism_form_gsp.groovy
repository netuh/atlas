import br.ufpe.cin.atlas.magnifier.AssociationMechanism
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_associationMechanism_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/associationMechanism/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: associationMechanismInstance, field: 'mechanism', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("associationMechanism.mechanism.label"),'default':("Mechanism")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: associationMechanismInstance, field: 'definedByAuthor', 'error'))
printHtmlPart(3)
invokeTag('message','g',15,['code':("associationMechanism.definedByAuthor.label"),'default':("Defined By Author")],-1)
printHtmlPart(4)
invokeTag('checkBox','g',18,['name':("definedByAuthor"),'value':(associationMechanismInstance?.definedByAuthor)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: associationMechanismInstance, field: 'domain', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("associationMechanism.domain.label"),'default':("Domain")],-1)
printHtmlPart(4)
invokeTag('textField','g',26,['name':("domain"),'value':(associationMechanismInstance?.domain)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: associationMechanismInstance, field: 'mechanismType', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("associationMechanism.mechanismType.label"),'default':("Mechanism Type")],-1)
printHtmlPart(4)
invokeTag('textField','g',34,['name':("mechanismType"),'value':(associationMechanismInstance?.mechanismType)],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: associationMechanismInstance, field: 'owner', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("associationMechanism.owner.label"),'default':("Owner")],-1)
printHtmlPart(9)
invokeTag('select','g',42,['id':("owner"),'name':("owner.id"),'from':(br.ufpe.cin.atlas.magnifier.PrimaryStudy.list()),'optionKey':("id"),'required':(""),'value':(associationMechanismInstance?.owner?.id),'class':("many-to-one")],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385573274000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
