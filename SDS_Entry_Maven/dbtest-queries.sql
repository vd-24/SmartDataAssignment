-- 1) Find total claimed_charge of the exported documents.
SELECT SUM(claimed_charge) AS total_claimed_charge FROM Document WHERE status = 'EXPORTED';

-- 2) Find insured_name, insured_address and claimed_charge for the documents that have status "TO_REPRICE" and customer id 1 and 2.
SELECT insured_name,insured_address,claimed_charge FROM Document INNER JOIN Batch on Document.batch_id = Batch.id WHERE insured_name IS NOT NULL AND customer_id=1 OR customer_id=2;
