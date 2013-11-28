import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_mechanismanalyseByYear_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mechanism/analyseByYear.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
for( study in (newList) ) {
printHtmlPart(2)
expressionOut.print(study.year)
printHtmlPart(3)
expressionOut.print(study.mech)
printHtmlPart(4)
expressionOut.print(study.total)
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',31,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(7)
invokeTag('set','g',33,['var':("entityName"),'value':(message(code: 'primaryStudy.label', default: 'PrimaryStudy'))],-1)
printHtmlPart(7)
createTagBody(2, {->
createClosureForHtmlPart(8, 3)
invokeTag('captureTitle','sitemesh',34,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',34,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',35,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('message','g',37,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(10)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(11)
invokeTag('message','g',40,['code':("default.home.label")],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('actionSubmit','g',51,['action':("analyseByYear"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(14)
})
invokeTag('form','g',52,['controller':("mechanism")],2)
printHtmlPart(15)
invokeTag('message','g',56,['code':("primaryStudy.byType.label"),'default':("Primary Studies by Study Type")],-1)
printHtmlPart(16)
for( study in (list) ) {
printHtmlPart(17)
expressionOut.print(study.key)
printHtmlPart(18)
for( aStudy in (study.value) ) {
printHtmlPart(19)
expressionOut.print(aStudy.getTitle())
printHtmlPart(20)
}
printHtmlPart(21)
}
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',69,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385153360000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
