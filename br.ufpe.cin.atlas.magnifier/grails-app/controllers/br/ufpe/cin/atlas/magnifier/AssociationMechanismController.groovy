package br.ufpe.cin.atlas.magnifier



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AssociationMechanismController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AssociationMechanism.list(params), model:[associationMechanismInstanceCount: AssociationMechanism.count()]
    }

    def show(AssociationMechanism associationMechanismInstance) {
        respond associationMechanismInstance
    }

    def create() {
        respond new AssociationMechanism(params)
    }

    @Transactional
    def save(AssociationMechanism associationMechanismInstance) {
        if (associationMechanismInstance == null) {
            notFound()
            return
        }

        if (associationMechanismInstance.hasErrors()) {
            respond associationMechanismInstance.errors, view:'create'
            return
        }

        associationMechanismInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'associationMechanismInstance.label', default: 'AssociationMechanism'), associationMechanismInstance.id])
                redirect associationMechanismInstance
            }
            '*' { respond associationMechanismInstance, [status: CREATED] }
        }
    }

    def edit(AssociationMechanism associationMechanismInstance) {
        respond associationMechanismInstance
    }

    @Transactional
    def update(AssociationMechanism associationMechanismInstance) {
        if (associationMechanismInstance == null) {
            notFound()
            return
        }

        if (associationMechanismInstance.hasErrors()) {
            respond associationMechanismInstance.errors, view:'edit'
            return
        }

        associationMechanismInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AssociationMechanism.label', default: 'AssociationMechanism'), associationMechanismInstance.id])
                redirect associationMechanismInstance
            }
            '*'{ respond associationMechanismInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AssociationMechanism associationMechanismInstance) {

        if (associationMechanismInstance == null) {
            notFound()
            return
        }

        associationMechanismInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AssociationMechanism.label', default: 'AssociationMechanism'), associationMechanismInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'associationMechanismInstance.label', default: 'AssociationMechanism'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
