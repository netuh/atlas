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
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'mechanismId', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("mechanism.mechanismId.label"),'default':("Mechanism Id")],-1)
printHtmlPart(2)
invokeTag('textArea','g',10,['name':("mechanismId"),'cols':("40"),'rows':("5"),'maxlength':("5000"),'value':(mechanismInstance?.mechanismId)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'title', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("mechanism.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',18,['name':("title"),'value':(mechanismInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'venue', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("mechanism.venue.label"),'default':("Venue")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['name':("venue"),'value':(mechanismInstance?.venue)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'year', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("mechanism.year.label"),'default':("Year")],-1)
printHtmlPart(7)
invokeTag('field','g',34,['name':("year"),'type':("number"),'value':(mechanismInstance.year),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: mechanismInstance, field: 'observation', 'error'))
printHtmlPart(8)
invokeTag('message','g',39,['code':("mechanism.observation.label"),'default':("Observation")],-1)
printHtmlPart(2)
invokeTag('textField','g',42,['name':("observation"),'value':(mechanismInstance?.observation)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385151949000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
