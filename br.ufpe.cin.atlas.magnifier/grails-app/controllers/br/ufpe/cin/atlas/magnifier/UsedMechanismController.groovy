package br.ufpe.cin.atlas.magnifier



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UsedMechanismController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UsedMechanism.list(params), model:[usedMechanismInstanceCount: UsedMechanism.count()]
    }

    def show(UsedMechanism usedMechanismInstance) {
        respond usedMechanismInstance
    }

    def create() {
        respond new UsedMechanism(params)
    }

    @Transactional
    def save(UsedMechanism usedMechanismInstance) {
        if (usedMechanismInstance == null) {
            notFound()
            return
        }

        if (usedMechanismInstance.hasErrors()) {
            respond usedMechanismInstance.errors, view:'create'
            return
        }

        usedMechanismInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usedMechanismInstance.label', default: 'UsedMechanism'), usedMechanismInstance.id])
                redirect usedMechanismInstance
            }
            '*' { respond usedMechanismInstance, [status: CREATED] }
        }
    }

    def edit(UsedMechanism usedMechanismInstance) {
        respond usedMechanismInstance
    }

    @Transactional
    def update(UsedMechanism usedMechanismInstance) {
        if (usedMechanismInstance == null) {
            notFound()
            return
        }

        if (usedMechanismInstance.hasErrors()) {
            respond usedMechanismInstance.errors, view:'edit'
            return
        }

        usedMechanismInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UsedMechanism.label', default: 'UsedMechanism'), usedMechanismInstance.id])
                redirect usedMechanismInstance
            }
            '*'{ respond usedMechanismInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UsedMechanism usedMechanismInstance) {

        if (usedMechanismInstance == null) {
            notFound()
            return
        }

        usedMechanismInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UsedMechanism.label', default: 'UsedMechanism'), usedMechanismInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usedMechanismInstance.label', default: 'UsedMechanism'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
