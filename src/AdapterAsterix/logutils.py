import logging

def setup_logging(name=__name__):
    logging.basicConfig(format='%(asctime)s - %(name)s.%(funcName)s - %(levelname)s - %(message)s', level=logging.DEBUG)
    log = logging.getLogger(name)
    return log

