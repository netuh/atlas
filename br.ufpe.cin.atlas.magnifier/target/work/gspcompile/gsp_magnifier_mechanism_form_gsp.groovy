import br.ufpe.cin.atlas.magnifier.Mechanism
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_mechanism_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mechanism/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'content', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("mechanism.content.label"),'default':("Content")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("content"),'value':(mechanismInstance?.content)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'definedByAuthor', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("mechanism.definedByAuthor.label"),'default':("Defined By Author")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',18,['name':("definedByAuthor"),'value':(mechanismInstance?.definedByAuthor)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'domain', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("mechanism.domain.label"),'default':("Domain")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("domain"),'value':(mechanismInstance?.domain)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'mechanismType', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("mechanism.mechanismType.label"),'default':("Mechanism Type")],-1)
printHtmlPart(2)
invokeTag('textField','g',34,['name':("mechanismType"),'value':(mechanismInstance?.mechanismType)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1383771407000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
